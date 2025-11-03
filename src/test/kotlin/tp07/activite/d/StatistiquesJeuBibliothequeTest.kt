package tp07.activite.d

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class StatistiquesJeuBibliothequeTest {

    // ========== Tests pour calculerMoyenneScore ==========

    @Test
    fun `calculerMoyenneScore avec plusieurs scores`() {
        // Given
        val scores = arrayOf(1500, 2300, 1800, 2100)

        // When
        val resultat = calculerMoyenneScore(scores)

        // Then
        assertEquals(1925.0, resultat, 0.01)
    }

        @Test
        fun `calculerMoyenneScore avec un seul score`() {
            // Given
            val scores = arrayOf(5000)

            // When
            val resultat = calculerMoyenneScore(scores)

            // Then
            assertEquals(5000.0, resultat, 0.01)
        }

        @Test
        fun `calculerMoyenneScore avec scores à zéro`() {
            // Given
            val scores = arrayOf(0, 0, 0)

            // When
            val resultat = calculerMoyenneScore(scores)

            // Then
            assertEquals(0.0, resultat, 0.01)
        }

        @Test
        fun `calculerMoyenneScore avec tableau vide lance exception`() {
            // Given
            val scores = arrayOf<Int>()

            // When & Then
            assertThrows<IllegalArgumentException> {
                calculerMoyenneScore(scores)
            }
        }

        // ========== Tests pour trouverMeilleurScore ==========

            @Test
            fun `trouverMeilleurScore avec score max au milieu`() {
                // Given
                val scores = arrayOf(1200, 3500, 2100, 1800)

                // When
                val resultat = trouverMeilleurScore(scores)

                // Then
                assertEquals(3500, resultat)
            }

            @Test
            fun `trouverMeilleurScore avec score max au début`() {
                // Given
                val scores = arrayOf(5000, 1200, 2100, 1800)

                // When
                val resultat = trouverMeilleurScore(scores)

                // Then
                assertEquals(5000, resultat)
            }

            @Test
            fun `trouverMeilleurScore avec score max à la fin`() {
                // Given
                val scores = arrayOf(1200, 2100, 1800, 4500)

                // When
                val resultat = trouverMeilleurScore(scores)

                // Then
                assertEquals(4500, resultat)
            }

            @Test
            fun `trouverMeilleurScore avec tous les scores identiques`() {
                // Given
                val scores = arrayOf(2000, 2000, 2000)

                // When
                val resultat = trouverMeilleurScore(scores)

                // Then
                assertEquals(2000, resultat)
            }

            @Test
            fun `trouverMeilleurScore avec un seul score`() {
                // Given
                val scores = arrayOf(3000)

                // When
                val resultat = trouverMeilleurScore(scores)

                // Then
                assertEquals(3000, resultat)
            }

            @Test
            fun `trouverMeilleurScore avec tableau vide lance exception`() {
                // Given
                val scores = arrayOf<Int>()

                // When & Then
                assertThrows<IllegalArgumentException> {
                    trouverMeilleurScore(scores)
                }
            }
/*            // ========== Tests pour calculerProgression ==========

            @Test
            fun `calculerProgression avec augmentation de score`() {
                // Given
                val scoreAvant = 1500
                val scoreApres = 2000

                // When
                val resultat = calculerProgression(scoreAvant, scoreApres)

                // Then
                assertEquals(33.33, resultat, 0.01)
            }

            @Test
            fun `calculerProgression avec diminution de score`() {
                // Given
                val scoreAvant = 2000
                val scoreApres = 1500

                // When
                val resultat = calculerProgression(scoreAvant, scoreApres)

                // Then
                assertEquals(-25.0, resultat, 0.01)
            }

            @Test
            fun `calculerProgression avec scores identiques`() {
                // Given
                val scoreAvant = 2000
                val scoreApres = 2000

                // When
                val resultat = calculerProgression(scoreAvant, scoreApres)

                // Then
                assertEquals(0.0, resultat, 0.01)
            }

            @Test
            fun `calculerProgression avec score avant à zéro lance exception`() {
                // Given
                val scoreAvant = 0
                val scoreApres = 1500

                // When & Then
                assertThrows<IllegalArgumentException> {
                    calculerProgression(scoreAvant, scoreApres)
                }
            }

            @Test
            fun `calculerProgression avec scores négatifs lance exception`() {
                // Given
                val scoreAvant = -1000
                val scoreApres = 1500

                // When & Then
                assertThrows<IllegalArgumentException> {
                    calculerProgression(scoreAvant, scoreApres)
                }
            }

            // ========== Tests pour obtenirNiveauJoueur ==========

            @Test
            fun `obtenirNiveauJoueur niveau Débutant`() {
                // Given
                val moyenneScore = 800.0

                // When
                val resultat = obtenirNiveauJoueur(moyenneScore)

                // Then
                assertEquals("Débutant", resultat)
            }

            @Test
            fun `obtenirNiveauJoueur niveau Intermédiaire`() {
                // Given
                val moyenneScore = 1500.0

                // When
                val resultat = obtenirNiveauJoueur(moyenneScore)

                // Then
                assertEquals("Intermédiaire", resultat)
            }

            @Test
            fun `obtenirNiveauJoueur niveau Avancé`() {
                // Given
                val moyenneScore = 2800.0

                // When
                val resultat = obtenirNiveauJoueur(moyenneScore)

                // Then
                assertEquals("Avancé", resultat)
            }

            @Test
            fun `obtenirNiveauJoueur niveau Expert`() {
                // Given
                val moyenneScore = 4500.0

                // When
                val resultat = obtenirNiveauJoueur(moyenneScore)

                // Then
                assertEquals("Expert", resultat)
            }

            @Test
            fun `obtenirNiveauJoueur à la limite Débutant-Intermédiaire`() {
                // Given
                val moyenneScore = 1000.0

                // When
                val resultat = obtenirNiveauJoueur(moyenneScore)

                // Then
                assertEquals("Débutant", resultat)
            }

            @Test
            fun `obtenirNiveauJoueur à la limite Intermédiaire-Avancé`() {
                // Given
                val moyenneScore = 2000.0

                // When
                val resultat = obtenirNiveauJoueur(moyenneScore)

                // Then
                assertEquals("Intermédiaire", resultat)
            }

            @Test
            fun `obtenirNiveauJoueur à la limite Avancé-Expert`() {
                // Given
                val moyenneScore = 3000.0

                // When
                val resultat = obtenirNiveauJoueur(moyenneScore)

                // Then
                assertEquals("Avancé", resultat)
            }

            @Test
            fun `obtenirNiveauJoueur avec score négatif lance exception`() {
                // Given
                val moyenneScore = -500.0

                // When & Then
                assertThrows<IllegalArgumentException> {
                    obtenirNiveauJoueur(moyenneScore)
                }
            }

         */
}