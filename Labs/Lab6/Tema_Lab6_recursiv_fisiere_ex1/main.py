import os
import abc


class GenericFile(abc.ABC):
    @abc.abstractmethod
    def get_path(self):
        pass

    @abc.abstractmethod
    def get_freq(self):
        pass


class TextAscii(GenericFile):
    def __init__(self, path, freq):
        self.path = path
        self.freq = freq

    def get_path(self):
        return self.path

    def get_freq(self):
        return self.freq


class TextUnicode(GenericFile):
    def __init__(self, path, freq):
        self.path = path
        self.freq = freq

    def get_path(self):
        return self.path

    def get_freq(self):
        return self.freq


class Binary(GenericFile):
    def __init__(self, path, freq):
        self.path = path
        self.freq = freq

    def get_path(self):
        return self.path

    def get_freq(self):
        return self.freq


class XMLFile(TextAscii):
    def __init__(self, path, freq, first_tag):
        super().__init__(path, freq)
        self.first_tag = first_tag

    def get_first_tag(self):
        return self.first_tag


class BMP(Binary):
    def __init__(self, path, freq, width, height, bpp):
        super().__init__(path, freq)
        self.width = width
        self.height = height
        self.bpp = bpp

    def show_info(self):
        print("--------------------")
        print("BMP:")
        print("\t" + super().get_path())
        print("\tWidth" + str(self.width))
        print("\tHeight" + str(self.width))
        print("\tBPP:" + str(self.bpp))


def generateFreq(content):
    freq = [0 for i in range(256)]
    for i in content:
        freq[i] = freq[i] + 1
    return freq


def isUnicode(freq):
    if freq[0] >= (len(freq) * (30 / 100)):
        return True
    else:
        return False


def isBinary(freq):
    for i in range(256):
        tmp = freq[i] * 100 / len(freq)
        if tmp > 0.05:
            if (tmp < (100 / 256) - 0.1) or (tmp > (100 / 256) + 0.1):
                return False
    return True


def isAscii(freq):
    sumBig = int(freq[9] + freq[10] + freq[13])
    cntBig = 3
    for i in range(32, 127):
        sumBig += freq[i]
        cntBig += 1

    avgBig = sumBig / cntBig

    sumL = 0
    cntL = 0
    for i in range(0, 8):
        sumL += freq[i]
        cntL += 1

    sumL += freq[11] + freq[12] + freq[14]
    cntL += 3

    for i in range(15, 31):
        sumL += freq[i]
        cntL += 1

    for i in range(128, 255):
        sumL += freq[i]
        cntL += 1

    avgL = sumL / cntL

    if avgBig > avgL * 2:
        return True
    return False


def main():
    ASCII = []
    UNICODE = []
    BINARY = []
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))
    for root, subdirs, files in os.walk(ROOT_DIR):
        for file in os.listdir(root):
            file_path = os.path.join(root, file)
            if os.path.isfile(file_path):
                # deschide fișierul spre acces binar
                f = open(file_path, 'rb')
                try:
                    # în content se va depune o listă de octeți
                    content = f.read()
                    freq = generateFreq(content)
                    if isAscii(freq):
                        ASCII.append(TextAscii(file_path, freq))
                    if isBinary(freq):
                        BINARY.append(Binary(file_path, freq))
                    if isUnicode(freq):
                        UNICODE.append(TextAscii(file_path, freq))

                finally:
                    f.close()

    print("------------------\nASCII")
    for i in ASCII:
        print("==============")
        print("\t" + i.get_path())

    print("------------------\nUNICODE")
    for i in UNICODE:
        print("==============")
        print("\t" + i.get_path())

    print("------------------\nBINARY")
    for i in BINARY:
        print("==============")
        print("\t" + i.get_path())


if __name__ == '__main__':
    main()
