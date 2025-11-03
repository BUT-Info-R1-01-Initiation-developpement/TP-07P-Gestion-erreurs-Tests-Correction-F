package tp07.activite.d

fun main() {
    try {
        print("Combien de parties as tu joué ? ")
        val nombreParties = readln().toInt()
        check(nombreParties > 0) { "Nombre de parties doit être strictement positif." }

        val scores = Array<Int>(nombreParties) { 0 }
        for(i in scores.indices) {
            print("Score de la partie ${i+1} : ")
            scores[i] = readln().toInt()
            check(scores[i] > 0) { "Un score ne peut pas être négatif." }
        }

        val scoreMoyen = calculerMoyenneScore(scores)

        println("""
            
            Score moyen : $scoreMoyen
            Meilleur score : ${trouverMeilleurScore(scores)}
            Niveau : ${obtenirNiveauJoueur(scoreMoyen)}
            Progression entre 1ere et dernière partie : ${calculerProgression(scores.first(), scores.last())}
           
        """.trimIndent())

        for (i in 0 until scores.size-1) {
            println("Progression entre la partie ${i+1} et la partie ${i+2}: ${calculerProgression(scores[i], scores[i+1])}")
        }

    } catch (e: NumberFormatException) {
        println("Tu dois saisir une nombre entier.")
    } catch (e: IllegalStateException) {
        println(e.message)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}