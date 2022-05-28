import os
import sqlite3
from collections import namedtuple
Book = namedtuple("Book", ["id", "title", "author", "publisher"])
class DatabaseManager:
CREATE_CMD = '''CREATE TABLE IF NOT EXISTS books (
id INTEGER PRIMARY KEY AUTOINCREMENT,
title VARCHAR(100) UNIQUE,
author VARCHAR(100) NOT NULL,
publisher VARCHAR(100))'''
INSERT_CMD = '''INSERT INTO books(title, author, publisher)
VALUES (?, ?, ?)'''
SELECT_BY_AUTHOR_CMD = '''SELECT * FROM books WHERE author=?'''
SELECT_BY_ID_CMD = '''SELECT * FROM books WHERE id = ?'''
UPDATE_CMD = '''UPDATE books SET title=?, author=?, publisher=?
WHERE id=?'''
DELETE_ALL_CMD = '''DELETE FROM books'''
CURRENT_PATH = os.path.dirname(os.path.abspath(__file__))
DATABASE_PATH = os.path.join(CURRENT_PATH, 'books.db')

def __init__(self):
    with sqlite3.connect(self.DATABASE_PATH) as db:
        cursor = db.cursor()
        cursor.execute(self.CREATE_CMD)
        cursor.close()

def insert(self, book):
    with sqlite3.connect(self.DATABASE_PATH) as db:
        cursor = db.cursor()
        cursor.execute(self.INSERT_CMD,
        (book.title, book.author, book.publisher))
        cursor.close()

def select_by_author(self, author):
    with sqlite3.connect(self.DATABASE_PATH) as db:
        cursor = db.cursor()
        cursor.execute(self.SELECT_BY_AUTHOR_CMD, (author,))
        rows = cursor.fetchall()
        cursor.close()
        return [Book(*row) for row in rows]

def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('PyCharm')

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
