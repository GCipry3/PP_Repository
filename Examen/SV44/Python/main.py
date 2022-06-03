class Hostel:
    def __init__(self):
        self.rooms = []

    def addRoom(self, room):
        self.rooms.append(room)

    def addDiscountAtRoom(self,roomNr,percentage):
        self.rooms[roomNr]=DiscountDecorator(self.rooms[roomNr],percentage)

    def addBarBillToPriceAtRoom(self,roomNr,barBill):
        self.rooms[roomNr]=RoomWithBarDecorator(roomNr,barBill)

    def showDetailsForRoom(self,roomNr):
        r=self.rooms[roomNr]
        print("Room {} has to pay {}\n\tIs it a VIP room? : {}".format(roomNr,r.getPrice(),r.getVIP_Status))
        print("\t\t".endswith(""))
        r.operation()

    def showDetailsForAllRooms(self):
        for r in range (0, len(self.rooms)):
            self.showDetailsForRoom(r)


class Room:
    def operation(self):
        pass

    def getNr(self):
        pass

    def getPrice(self):
        pass

    def getVIP_Status(self):
        pass

    def setPrice(self, newPrice):
        pass


class HostelRoom(Room):
    def __init__(self, number, price, vip):
        self.nr = number
        self.price = price
        self.isVIP = vip

    def getNr(self):
        return self.nr

    def getPrice(self):
        return self.price

    def getVIP_Status(self):
        return self.isVIP

    def setPrice(self, newPrice):
        self.price = newPrice

    def operation(self):
        print("Hello! I'm the concrete class , HostelRoom")


class DecoratorRoom(Room):
    def __init__(self, room):
        self.nr = room.getNr()
        self.price = room.getPrice()
        self.isVIP = room.getVIP_Status()

    def getNr(self):
        return self.nr

    def getPrice(self):
        return self.price

    def getVIP_Status(self):
        return self.isVIP

    def setPrice(self, newPrice):
        self.price = newPrice

    def operation(self):
        pass

    def wrap(self):
        pass


class DiscountDecorator(DecoratorRoom):
    def __init__(self, room, percentage):
        super().__init__(room)
        self.percentage = percentage
        self.wrap()
        self.room = room

    def printDiscountFormula(self):
        print("{}-{}%={}".format(self.room.getPrice(), self.getDiscount(), self.getPrice()))

    def operation(self):
        self.room.operation()
        print("\tHello! I'm a decorator, DiscountDecorator")

    def wrap(self):
        price = self.getPrice()
        self.setPrice(price - self.percentage * price / 100)

    def getDiscount(self):
        return self.percentage


class RoomWithBarDecorator(DecoratorRoom):
    def __init__(self, room, barBill):
        super().__init__(room)
        self.barBill = barBill
        self.wrap()
        self.room = room

    def operation(self):
        self.room.operation()
        print("\tHello! I'm a decorator, RoomWithBarDecorator")

    def wrap(self):
        self.price += self.barBill

    def getBarBill(self):
        return self.barBill


if __name__ == '__main__':
    hostel=Hostel()

    r1 = HostelRoom(1, 100, False)
    r2 = HostelRoom(2, 15, True)
    r3 = HostelRoom(3, 125,False)

    hostel.addRoom(r1)
    hostel.addRoom(r2)
    hostel.addRoom(r3)

    hostel.addDiscountAtRoom(2,50)
    hostel.addBarBillToPriceAtRoom(1,120)
    hostel.showDetailsForAllRooms()