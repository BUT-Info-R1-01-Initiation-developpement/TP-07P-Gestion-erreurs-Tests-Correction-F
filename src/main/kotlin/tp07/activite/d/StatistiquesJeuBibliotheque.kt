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

fun trouverMeilleurScore(scores: Array<Int>): Int {
    require(!scores.isEmpty()) {
        "Le tableau de scores ne peut pas être vide pour calculer une moyenne."
    }
    var scoreMax = scores[0]
    for(i in 1 until scores.size) {
        if (scores[i] > scoreMax) {
            scoreMax = scores[i]
        }
    }
    return scoreMax
}

fun calculerProgression(scoreAvant: Int, scoreApres: Int): Double {
    require(scoreAvant > 0) { "Le score avant ne peut pas être négatif ou 0" }
    require(scoreApres >= 0) { "Le score apres ne peut pas être négatif" }
    return (scoreApres.toDouble() - scoreAvant)/scoreAvant * 100
}

fun obtenirNiveauJoueur(moyenneScore: Double): String {
    require(moyenneScore >= 0) { "Le score moyen ne peut pas être négatif." }
    return when {
        moyenneScore in 0.0..1000.0 -> "Débutant"
        moyenneScore <= 2000.0 -> "Intermédiaire"
        moyenneScore <= 3000.0 -> "Avancé"
        else -> "Expert"
    }
}