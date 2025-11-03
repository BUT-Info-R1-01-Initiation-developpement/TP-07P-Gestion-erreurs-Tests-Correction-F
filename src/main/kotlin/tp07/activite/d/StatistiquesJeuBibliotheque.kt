package tp07.activite.d

fun calculerMoyenneScore(scores: Array<Int>): Double {
    require(!scores.isEmpty()) {
        "Le tableau de scores ne peut pas être vide pour calculer une moyenne."
    }
    var somme = 0
    for (score in scores) {
        somme += score
    }
    val moyenne = somme.toDouble() / scores.size
    return moyenne
}