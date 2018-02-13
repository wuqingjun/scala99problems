def wordDistance(words: List[String], word1: String, word2: String) : Int = {
  var i1 = -1
  var i2 = -1
  var wc = 0
  var res = Int.MaxValue
  for(i <- 0 until words.length) {
    if(words(i) == word1) { if(i1 < 0) wc += 1;  i1 = i; }
    else if(words(i) == word2) {if(i2 < 0) wc += 1; i2 = i; }
    if(wc == 2){
      res = Math.min(res, Math.abs(i1 - i2))
    }
  }
  res
}

val jobName = "testJobName"

val query = s"""{ "query": { "bool": { "must": { "match": {"jobName": "${jobName}"} } } }, "sort": [{"timestamp": {"order": "desc"}}] } """
query

case class OffsetRange(topic: String, partition: Int, fromOffset: Long)

val arr = Array(OffsetRange("Patient", 0, 112), OffsetRange("Patient", 1, 131), OffsetRange("Condition", 0, 321))

arr.groupBy(a => a.topic).map(a =>  Map("id" -> (a._1 + "_")))


val topicList = List("Patient", "Condition")
val topicsString = topicList.map(t => "\"" + jobName + "_" + t + "\"").mkString(",")
val query2 = """{ "size": 1,  "query": { "terms": { "_id" : [""" + topicsString + """] }}, "sort": [{"timestamp": {"order": "desc"}}] } """
