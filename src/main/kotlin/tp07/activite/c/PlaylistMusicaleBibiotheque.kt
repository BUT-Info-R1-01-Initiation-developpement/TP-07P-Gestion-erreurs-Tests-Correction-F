package tp07.activite.c

fun calculerDureeTotale(durees: Array<Int>): Int {
    var dureeTotale = 0
    for (duree in durees) {
        dureeTotale += duree
    }
    return dureeTotale
}

fun trouverIndexChansonPlusLongue(durees: Array<Int>): Int {
    require(durees.isNotEmpty()) {"Le tableau des durées ne peut pas être vide pour trouver la/une durée la plus longue."}
    var indexPlusLongue = 0
    //var dureePlusLongue = durees[0]
    for (i in 1 until durees.size) {
        if (durees[i] > durees[indexPlusLongue]) {
            //dureePlusLongue = durees[i]
            indexPlusLongue = i
        }
    }
    return indexPlusLongue
}

fun ajouterChanson(
    titres: Array<String>,
    durees: Array<Int>,
    indice: Int,
    titre: String,
    duree: Int
) {
    require(duree > 0) {"❌ La durée doit être positive !"}
    require(duree <= 600) {"❌ La durée ne peut pas dépasser 10 minutes (600 secondes) !"}
    require(indice in titres.indices) { "❌ Indice invalide !"}
    require(titre.isNotBlank()) { "❌ Le titre ne doit pas être vide !" }
    titres[indice] = titre
    durees[indice] = duree
}