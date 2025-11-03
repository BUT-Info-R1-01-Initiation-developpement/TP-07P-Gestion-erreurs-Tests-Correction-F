package tp07.activite.d

const val DEBUTANT = "Débutant"
const val INTERMEDIAIRE = "Intermédiaire"
const val AVANCE = "Avancé"
const val EXPERT = "Expert"

/**
 *  Calcule la moyenne des scores.
 *
 *  @param scores le tableau contenant la liste des scores
 *  @return la moyenne des scores
 *
 *  @throws IllegalArgumentException si le tableau est vide
 */
fun calculerMoyenneScore(scores: Array<Int>): Double {
    require(scores.isNotEmpty()) { "Le tableau de scores ne peut pas être vide pour calculer une moyenne."}
    var somme = 0
    for (i in scores.indices) {
        somme += scores[i]
    }
    val moyenne = somme.toDouble() / scores.size
    return moyenne
}

/**
 * Trouve le meilleur score.
 *
 * @param scores le tableau des scores du joueur
 * @return le meilleur score
 *
 *  @throws IllegalArgumentException si le tableau est vide
 */
fun trouverMeilleurScore(scores: Array<Int>): Int {
    require(scores.isNotEmpty()) { "Le tableau de scores ne peut pas être vide pour trouver un meilleur score."}
    var meilleurScore = scores[0]
    for (i in 1 until scores.size) {
        if (scores[i] > meilleurScore) {
            meilleurScore = scores[i]
        }
    }
    return meilleurScore
}

/**
 * Calcule la progession d'un joueur entre 2 scores.
 *
 * @param scoreAvant le score initial du joueur
 * @param scoreApres le score d'après du joueur
 * @return la progression en pourcentage
 *
 *  @throws IllegalArgumentException si l'un des scores est négatif
 */
fun calculerProgression(scoreAvant: Int, scoreApres: Int): Double {
    require(scoreAvant > 0) {"Le premier score doit être strictement positif."}
    require(scoreApres >= 0) {"Le second score doit être positif"}
    return (scoreApres - scoreAvant) / scoreAvant.toDouble() * 100
}



/**
 * Obtient niveau du joueur en fonction de son score moyen
 * Débutant : moyenne ≤ 1000
 * Intermédiaire : 1000 < moyenne ≤ 2000
 * Avancé : 2000 < moyenne ≤ 3000
 * Expert : moyenne > 3000
 *
 * @param scoreMoyen le score moyen du joueur
 * @return le niveau du joueur.
 *
 * @throws IllegalArgumentException si le score moyen est négatif
 */
fun obtenirNiveauJoueur(scoreMoyen: Double): String {
    require(scoreMoyen >= 0) {"Le score moyen ne peut pas être négatif."}
    return when {
        scoreMoyen <= 1000.0 -> DEBUTANT
        scoreMoyen <= 2000.0 -> INTERMEDIAIRE
        scoreMoyen <= 3000.0 -> AVANCE
        else -> EXPERT
    }
}