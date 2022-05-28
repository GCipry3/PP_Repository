package org.example
import khttp.get
import khttp.responses.Response
import org.json.XML
import org.yaml.snakeyaml.Yaml
import java.net.URL

class Crawler
{
    private var url:String=""

    constructor( url:String )
    {
        this.url=url
    }

    public fun getResources(): Response {
        return get("$url")
    }

    public fun processContent(contentType: String)
    {
        var apiResponse = URL("$url").readText()
        when(contentType)
        {
            "json" ->
            {
                apiResponse=apiResponse.substring( 1, apiResponse.length - 1 )
                val data = JsonParser()
                println(data.parse(apiResponse))
            }
            "xml" ->
            {
                val data=XMLParser()
                println(data.parse(apiResponse))
            }
            "yaml" ->
            {
                val data = YamlParser()
                println(data.parse(apiResponse))
            }

        }
    }

}

interface Parser {
    fun parse(text:String): MutableMap<String, Any>?
}

class JsonParser: Parser {
    override fun parse(text:String): MutableMap<String, Any>? {
        val jsonText = XML.toJSONObject(text)
        //val jsonText=JSONObject(text)
        return jsonText.toMap()
    }
}

class XMLParser :Parser{
    override fun parse(text:String): MutableMap<String, Any>? {
        val jsonObj = XML.toJSONObject(text)
        //val aux = jsonObj.toString()
        return jsonObj.toMap()
    }
}

class YamlParser: Parser {
    override fun parse(text:String): MutableMap<String, Any>? {
        val yaml = Yaml()
        val data: MutableMap<String, Any> = yaml.load(text)
        return data
    }
}

fun main(args: Array<String>) {
    var json=Crawler("https://www.w3schools.com/xml/plant_catalog.xml") //folosesc la json acelasi xml ca urmatorul pentru ca am un converter in functie (from xml to json)
    var xml=Crawler("https://www.w3schools.com/xml/plant_catalog.xml")

    var yaml=Crawler("")
    println("------------------------------------------------------------")
    println("HttpResponse: ")
    println(json.getResources())
    println("------------------------------------------------------------")
    println("processContent(json):")
    json.processContent("json")
    println("------------------------------------------------------------")
    println("processContent(xml):")
    xml.processContent("xml")
    println("------------------------------------------------------------")
    println("processContent(yaml):") //Functia merge , dar nu am putut gasi un url de yaml
    //yaml.processContent("yaml")
}

