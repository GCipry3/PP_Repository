import subprocess

if __name__ == '__main__':
    command = "ip a | grep inet | wc -l"
    commands = command.split(" | ")
    process = []

    for c in commands:
        if process:
            process.append(
                subprocess.Popen(
                    c,
                    stdin=process[-1].stdout,
                    shell=True,
                    stdout=subprocess.PIPE)
            )
        else:
            process.append(
                subprocess.Popen(
                    c,
                    shell=True,
                    stdout=subprocess.PIPE)
            )

    print(process[-1].stdout.read())
