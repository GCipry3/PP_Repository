class Start_Date:Data<String>
{
    var startDate = mutableListOf<String>()

    override fun Get(): MutableList<String> {
        return startDate
    }

    override fun Set(list: MutableList<String>) {
        startDate=list
    }

    override fun Add(string: String) {
        startDate.add(string)
    }

}