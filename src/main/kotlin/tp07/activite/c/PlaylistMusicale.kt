package tp07.activite.c

/**
 * Programme de gestion d'une playlist musicale
 */

fun main() {
    println("=== Gestion de Playlist Musicale ===\n")

    try {
        // Demander le nombre de chansons
        print("Combien de chansons dans votre playlist ? ")
        val nombreChansons = readln().toInt()
        check(nombreChansons > 0) {"❌ Le nombre de chansons doit être positif !"}

        // Créer les tableaux pour stocker les titres et durées
        val titres = Array<String>(nombreChansons) { "" }
        val durees = Array<Int>(nombreChansons) { 0 }

        // Saisir chaque chanson
        println("\nSaisissez les informations de chaque chanson :")
        for (i in 0 until nombreChansons) {
            println("\n--- Chanson ${i + 1} ---")
            print("Titre : ")
            titres[i] = readln()
            check(titres[i].isNotEmpty()) { "❌ Le titre ne doit pas être vide !" }
            print("Durée (en secondes) : ")
            durees[i] = readln().toInt()
            check(durees[i] > 0) {"❌ La durée doit être positive !"}
            check(durees[i] <= 600) {"❌ La durée ne peut pas dépasser 10 minutes (600 secondes) !"}
        }

        // Calculer la durée totale
        var dureeTotal = 0
        for (duree in durees) {
            dureeTotal += duree
        }

        // Convertir en minutes et secondes
        val minutes = dureeTotal / 60
        val secondes = dureeTotal % 60

        // Trouver la chanson la plus longue
        var indexPlusLongue = 0
        var dureePlusLongue = durees[0]
        for (i in 1 until nombreChansons) {
            if (durees[i] > dureePlusLongue) {
                dureePlusLongue = durees[i]
                indexPlusLongue = i
            }
        }

        // Afficher les résultats
        println("\n=== Résumé de votre playlist ===")
        println("Nombre de chansons : $nombreChansons")
        println("Durée totale : ${minutes}min ${secondes}s")
        println("Chanson la plus longue : ${titres[indexPlusLongue]} (${dureePlusLongue}s)")

        println("\n=== Liste des chansons ===")
        for (i in 0 until nombreChansons) {
            val min = durees[i] / 60
            val sec = durees[i] % 60
            println("${i + 1}. ${titres[i]} - ${min}:${sec.toString().padStart(2, '0')}")
        }

    } catch (e: NumberFormatException) {
        println("\n❌ Erreur : Vous devez saisir un nombre valide !")
    } catch (e: IllegalStateException) {
        println(e.message)
    }
}