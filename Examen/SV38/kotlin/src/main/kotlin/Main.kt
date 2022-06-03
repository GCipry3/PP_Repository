fun genSubCollections(A:List<Int>): List<List<Int>> {
    var B:MutableList<List<Int>> = mutableListOf(listOf())
    var tmp:List<Int> = listOf()

    for(i in A.indices) {
        for (j in i + 1 until A.size) {
            for (k in j + 1 until A.size) {
                for (l in k + 1 until A.size) {
                    tmp = tmp.plus(A[i])
                    tmp = tmp.plus(A[j])
                    tmp = tmp.plus(A[k])
                    tmp = tmp.plus(A[l])

                    B.add(tmp)
                    tmp= listOf()
                }
            }
        }
    }
    return B.toList()
}

fun contains1(A:List<Int>):Boolean{
    A.forEach{if(it==1 || it/10 ==1 || it%10==1) {
            println(A)
            return true
        }
    }
    return false
}

fun main(args: Array<String>) {
    var A= generateSequence(0) { it+1 }.take(100).toList()
    var B=genSubCollections(A).filter(::contains1)
    //println(B)
    println(B.size)

}