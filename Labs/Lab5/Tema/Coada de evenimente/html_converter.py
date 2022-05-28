import codecs
import os
import sys
import PyQt5
import io
import subprocess
from PyQt5.QtWidgets import QWidget, QApplication, QFileDialog
from PyQt5.uic import loadUi
from PyQt5 import QtCore
import queue


def debug_trace(ui=None):
    from pdb import set_trace
    QtCore.pyqtRemoveInputHook()
    set_trace()
    # QtCore.pyqtRestoreInputHook()


class HTMLConverter(QWidget):
    queue_var = queue.Queue()
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))

    def __init__(self):
        super(HTMLConverter, self).__init__()
        ui_path = os.path.join(self.ROOT_DIR, 'html_converter.ui')
        loadUi(ui_path, self)
        self.browse_btn.clicked.connect(self.browse)
        self.pushButton_1.clicked.connect(self.parse)
        self.ViewHTML.clicked.connect(self.viewHTML)
        self.CCODE.clicked.connect(self.compile)

        self.file_path = None
        self.text = None

    def browse(self):
        options = QFileDialog.Options()
        options |= QFileDialog.DontUseNativeDialog
        file, _ = QFileDialog.getOpenFileName(self,
                                              caption='Select file',
                                              directory='',
                                              filter="Text Files (*.txt)",
                                              options=options)
        if file:
            self.file_path = file
            self.path_line_edit.setText(file)
            print(file)

    def parse(self):
        f = open(self.file_path, "r")
        fw = open("input.txt", "w")
        if f:
            text = f.read()
            self.text = text
            fw.write(text)

        self.ViewTXT_edit.setText(self.text)
        fw.close()
        f.close()

    def compile(self):
        print("---------------------------------------------")
        subprocess.call(["gcc", "CFunc.c"])
        f = open("code.html", "r")
        fw = open("inputFromTail.txt", "w")
        if f:
            line = f.readline()
            while line:
                self.queue_var.put(line)
                line = f.readline()
                line = line[0:len(line) - 1]

        while not self.queue_var.empty():
            fw.seek(0)
            fw.write(self.queue_var.get())
            fw.truncate()
            subprocess.call(["./a.out"])

        f.close()

    def viewHTML(self):
        # f = codecs.open("code.html", "r", "utf-8")
        f = open("input.txt", "r")

        if f:
            line = f.readline()

            if line:
                text = "<html>\n"
                text += "\t<head>\n"
                text += "\t\t<title>"
                text += line[0:len(line) - 1]
                text += "</title>\n\t</head>\n"

            line = f.readline()

            if line:
                text += "\t<body>\n"
                text += "\t\t<h1>"
                text += line[0:len(line) - 1]
                text += "</h1>\n"

            line = f.readline()
            while line:
                text += "\t\t<p>"
                text += line[0:len(line) - 1]
                text += "</p>\n"
                line = f.readline()

            text += "\t</body>\n"
            text += "</html> "
            f.close()
            f = open("code.html", "w")
            f.write(text)

            self.text = text

        self.ViewTXT_edit.setText(self.text)


if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = HTMLConverter()
    window.show()
    sys.exit(app.exec_())
