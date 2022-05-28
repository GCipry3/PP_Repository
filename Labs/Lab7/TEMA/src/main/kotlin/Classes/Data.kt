interface Data<T>
{
    fun Get():MutableList<T>
    fun Set(list:MutableList<T>)
    fun Add(string: T)
}