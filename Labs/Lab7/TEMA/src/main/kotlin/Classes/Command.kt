class Command:Data<String>
{
    var commands = mutableListOf<String>()

    override fun Get(): MutableList<String> {
        return commands
    }

    override fun Set(list: MutableList<String>) {
        commands=list
    }

    override fun Add(string: String) {
        commands.add(string)
    }

}