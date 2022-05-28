from tkinter import *


class TikTacToe:
    def __init__(self):
        self.colors = {
            0: "#b3e6ff",
            1: "#66ccff",
            2: "#0099e6",
        }
        self.counter = 0
        self.root = Tk()
        self.root.geometry("450x450")
        self.window = Frame(self.root)
        self.window.pack()
        self.btn = [[' ' for i in range(3)] for j in range(3)]
        self.button = [[0 for i in range(3)] for j in range(3)]
        self.imgO = PhotoImage(file="o.png")
        self.imgX = PhotoImage(file="x.png")
        self.img = PhotoImage(width=1, height=1)
        # for i in range(3):
        #     for j in range(3):
        #         self.button[i][j] = Button(self.window, width=150, height=150,
        #                         relief="groove", image=self.img, bg=self.colors[i], textvariable=self.btn[i][j], command=lambda:
        #                         self.pressed(i, j), compound="c") self.button[i][j].grid(row=i, column=j)

        self.button[0][0] = Button(self.window, width=150, height=150, relief="groove", image=self.img,
                                   bg=self.colors[0],
                                   textvariable=self.btn[0][0], command=lambda: self.pressed(0, 0), compound="c")
        self.button[0][0].grid(row=0, column=0)

        self.button[0][1] = Button(self.window, width=150, height=150, relief="groove", image=self.img,
                                   bg=self.colors[0],
                                   textvariable=self.btn[0][1], command=lambda: self.pressed(0, 1), compound="c")
        self.button[0][1].grid(row=0, column=1)

        self.button[0][2] = Button(self.window, width=150, height=150, relief="groove", image=self.img,
                                   bg=self.colors[0],
                                   textvariable=self.btn[0][2], command=lambda: self.pressed(0, 2), compound="c")
        self.button[0][2].grid(row=0, column=2)

        self.button[1][0] = Button(self.window, width=150, height=150, relief="groove", image=self.img,
                                   bg=self.colors[1],
                                   textvariable=self.btn[1][0], command=lambda: self.pressed(1, 0), compound="c")
        self.button[1][0].grid(row=1, column=0)

        self.button[1][1] = Button(self.window, width=150, height=150, relief="groove", image=self.img,
                                   bg=self.colors[1],
                                   textvariable=self.btn[1][1], command=lambda: self.pressed(1, 1), compound="c")
        self.button[1][1].grid(row=1, column=1)

        self.button[1][2] = Button(self.window, width=150, height=150, relief="groove", image=self.img,
                                   bg=self.colors[1],
                                   textvariable=self.btn[1][2], command=lambda: self.pressed(1, 2), compound="c")
        self.button[1][2].grid(row=1, column=2)

        self.button[2][0] = Button(self.window, width=150, height=150, relief="groove", image=self.img,
                                   bg=self.colors[2],
                                   textvariable=self.btn[2][0], command=lambda: self.pressed(2, 0), compound="c")
        self.button[2][0].grid(row=2, column=0)

        self.button[2][1] = Button(self.window, width=150, height=150, relief="groove", image=self.img,
                                   bg=self.colors[2],
                                   textvariable=self.btn[2][1], command=lambda: self.pressed(2, 1), compound="c")
        self.button[2][1].grid(row=2, column=1)

        self.button[2][2] = Button(self.window, width=150, height=150, relief="groove", image=self.img,
                                   bg=self.colors[2],
                                   textvariable=self.btn[2][2], command=lambda: self.pressed(2, 2), compound="c")
        self.button[2][2].grid(row=2, column=2)

        self.play()

    def play(self):
        self.root.mainloop()

    def pressed(self, r, c):
        print(r)
        print(c)
        if self.counter <= 8:
            if self.counter % 2 == 0:
                Label(self.window, image=self.imgX).grid(row=r, column=c)
                self.btn[r][c] = "X"
                if self.checkWin('X'):
                    self.window.destroy()
                    self.winFrame = Frame(self.root)
                    self.winFrame.pack()
                    txt=Text(height=20)
                    txt.pack()
                    txt.configure(font=("Times New Roman", 20, "italic"))
                    Label(self.winFrame,text="Playerul X a castigaat",fg="red",background="blue",anchor="center").pack()


                self.counter += 1
            else:
                Label(self.window, image=self.imgO).grid(row=r, column=c),
                self.btn[r][c] = "O"
                if self.checkWin('O'):
                    self.window.destroy()
                    self.winFrame = Frame(self.root)
                    self.winFrame.pack()
                    txt=Text(height=20)
                    txt.pack()
                    txt.configure(font=("Times New Roman", 20, "italic"))
                    Label(self.winFrame,text="Playerul O a castigaat",fg="red",background="blue",anchor="center").pack()
                self.counter += 1
        else:
            self.window.destroy()

    def checkWin(self, l):
        if (self.btn[0][0] == l and self.btn[0][1] == l and self.btn[0][2] == l) or (
                self.btn[1][0] == l and self.btn[1][1] == l and self.btn[1][2] == l) or (
                self.btn[2][0] == l and self.btn[2][1] == l and self.btn[2][2] == l) or (
                self.btn[0][0] == l and self.btn[1][1] == l and self.btn[2][2] == l) or (
                self.btn[0][2] == l and self.btn[1][1] == l and self.btn[2][0] == l) or (
                self.btn[0][0] == l and self.btn[1][0] == l and self.btn[2][0] == l) or (
                self.btn[0][1] == l and self.btn[1][1] == l and self.btn[2][1] == l) or (
                self.btn[0][2] == l and self.btn[1][2] == l and self.btn[2][2] == l):
            return 1

        return 0


if __name__ == '__main__':
    game = TikTacToe()
