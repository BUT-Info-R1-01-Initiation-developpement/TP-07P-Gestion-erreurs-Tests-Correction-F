package tp07.activite.b

/**
 * Programme de gestion de notes d'examen
 * Utilise require() et check() pour valider les données
 */

/**
 * Calcule la moyenne de plusieurs notes
 * @param notes Tableau des notes (doivent être entre 0 et 20)
 * @return La moyenne des notes
 */
fun calculerMoyenne(notes: Array<Double>): Double {
    // Expliquez en français les pré-conditions exprimées dans le code de la fonction calculerMoyenne.
    // Le tableau de notes ne doit pas être vide.
    // Chaque not du tableau est comprise entre 0.0 et 20.0
    // Quel type d'exception sera lancée par la fonction si l'une des pré-conditions n'est
    // pas satisfaite ?
    // Une exception de type IllegalArgumentException sera lancée si une des pré-conditions n'est pas staisfaite.


    require(notes.isNotEmpty()) {
        "Impossible de calculer une moyenne sans notes !"
    }

    // Vérifier que toutes les notes sont valides
    for (note in notes) {
        require(note in 0.0..20.0) {
            "La note $note est invalide : doit être entre 0 et 20"
        }
    }

    var somme = 0.0
    for (note in notes) {
        somme += note
    }
    val moyenne = somme / notes.size

    // Expliquez en français la post-condition exprimée dans le code de la fonction calculerMoyenne.
    // La moyenne doit être comprise entre 0 et 20
    // Quel type d'exception sera lancée par la fonction si la pré-condition n'est
    // pas satisfaite ?
    // Une exception de type IllegalStateException sera lancée si une des post-conditions n'est pas staisfaite.

    check(moyenne in 0.0..20.0) {
        "Erreur de calcul : la moyenne devrait être entre 0 et 20"
    }

    return moyenne
}

fun main() {
    println("=== Calcul de moyenne d'examen ===\n")
    // Quel sont les avantages principaux à utiliser les blocs try et catch dans le programme principal ?
    // Permet de gérer toutes les erreurs de manière
    // - uniforme
    // - centralisée
    // - à personnaliser le flux du programme pour qu'il reste "use friendly"
    try {
        // Demander le nombre de notes
        print("Combien de notes voulez-vous saisir ? ")
        val nombreNotes = readln().toInt()
        check(nombreNotes > 0) { "Le nombre de notes doit être supérieur à 0." }

        // Créer un tableau pour stocker les notes
        val notes = Array<Double>(nombreNotes) { 0.0 }

        // Saisir chaque note
        for (i in 0 until nombreNotes) {
            print("Note ${i + 1} : ")
            val note = readln().toDouble()
            notes[i] = note
        }

        // Calculer et afficher la moyenne
        val moyenne = calculerMoyenne(notes)
        println("\n✓ Notes saisies : ${notes.contentToString()}")
        println("✓ Moyenne : $moyenne")

    } catch (e: NumberFormatException) {
        println("\n❌ Erreur : Vous devez saisir un nombre valide !")
    } catch (e: IllegalArgumentException) {
        println("\n❌ Erreur : ${e.message}")
    } catch (e: IllegalStateException) {
        println("\n❌ Erreur : ${e.message}")
    }
}
