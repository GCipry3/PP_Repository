import asyncio


async def suma(name, number):
    s = 0
    for i in range(0, number):
        print(f"Task {name}:Compute sum({i})...")
        s += i
    print(f"Task {name}:Suma pana la ({number}) = {s}")


async def main():
    await asyncio.gather(
        suma("A", 10),
        suma("B", 15),
        suma("C", 5),
        suma("D", 2)
    )


if __name__ == '__main__':
    asyncio.run(main())
