from tkinter import *

class TikTakToe:
    def __init__(self):
        self.root = Tk()
        self.imgX = PhotoImage(file="x.png")
        self.imgO = PhotoImage(file="o.png")
        self.root.geometry("1000x1000")
        self.frame = Frame(self.root)
        self.frame.pack()

        self.button1 = Button(self.frame, width=150, height=150, relief="groove", image=self.imgX, compound="c")
        self.button1.pack()
        self.root.mainloop()


if __name__ == '__main__':
    tmp = TikTakToe()