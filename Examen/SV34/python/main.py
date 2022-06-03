"""from tkinter import *


def clickExitButton():
    exit()


def printHi():
    print("hello")


class Window(Frame):
    def __init__(self, master=None):
        Frame.__init__(self, master)
        self.pressButton = None
        self.exitButton = None
        self.master = master
        self.pack(fill=BOTH, expand=1)

    def addExitButton(self):
        self.exitButton = Button(self, text="EXIT", command=clickExitButton)
        self.exitButton.place(x=0, y=0)

    def addPressButton(self):
        self.pressButton = Button(self, text="Press", bg="red", command=printHi)
        self.pressButton.place(x=50, y=50)


if __name__ == '__main__':
    root = Tk()
    app = Window(root)
    app.addExitButton()
    app.addPressButton()
    root.geometry("300x300")
    root.mainloop()"""
import tkinter as tk
from matplotlib import pyplot as plt
from matplotlib.backends._backend_tk import NavigationToolbar2Tk
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
from matplotlib.figure import Figure


class App(tk.Tk):
    def __init__(self):
        super().__init__()

        y = []
        n = 5

        for s in range(20, 50):
            y.append(s - n + sum(i for i in range(0, n - 1)))

        frame = tk.Frame(self)

        figure = Figure(figsize=(5, 5), dpi=100)
        canvas = FigureCanvasTkAgg(figure, frame)
        NavigationToolbar2Tk(canvas, self).update()
        chart = figure.add_subplot(111)
        chart.plot(y)

        canvas.get_tk_widget().grid(row=0, column=0, padx=50, pady=50)

        frame2=tk.Frame(frame,width=500,height=500,bg='gray')
        s=0
        for i in range(0,n):
            s+=i
            tk.Label(frame2,text="i= "+str(i)+" ; Avand suma curenta= "+str(s),fg='black',bg='white').pack()

        frame2.grid(row=0, column=1, padx=50)

        frame.pack()


def main():
    app = App()
    app.mainloop()


if __name__ == '__main__':
    main()
