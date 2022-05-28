class Singleton {
    private constructor(){}

    companion object {
        private var instance: Singleton? = null

        @JvmName("getInstance1")
        fun getInstance(): Singleton? {
            if(instance==null){
                instance=Singleton()
            }
            return instance
        }
    }

    fun operation(){
        println("Singleton | Do something")
    }
}

object ObjectSingleton{
    fun operation(){
        println("ObjectSingleton | Do something")
    }
}