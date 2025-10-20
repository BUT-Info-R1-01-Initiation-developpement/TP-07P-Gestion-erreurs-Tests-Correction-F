package tp07.activite.b

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class CalculerMoyenneTest {

    // Regarde les noms des fonctions : ils contiennent des espaces.
    // Mais, as-tu repéré dans la syntaxe Kotlin, à quelle condition cela était possible ?
    // C'est possible uniquement si le nom de la fonction est encadré par ``.
    // Attention : cette approche n'est recommandée que pour les fonctions de tests car elle facilite
    // La lecture des résultats des tests.

    // Dans les tests ci-dessous, qu'est-ce qui correspond :
    // - aux tests du ou des cas nominaux ?
    // `test moyenne avec notes valides`()
    // toutes les notes à 20, ou à 0
    // - aux tests du ou des cas limites ?
    // `test moyenne avec une seule note`()
    // - aux tests du ou des cas d'erreur ?
    // - tableau vide
    // - cas des notes négatives ou supérieur 0

    // Lance les tests avec la mesure de la couverture du code par les tests.
    // Est-ce que la fonction calculerMoyenne() est couverte à 100% ?
    //
    // Si elle n'est pas couverte à 100%, dans ce cas, peut-on considérer que la non couverture à 100%
    // est acceptable ?
    // Oui, il est acceptable de pas avoir 100% car, 100% révèlerait un bug dans le programme
    // ...

    @Test
    fun `test moyenne avec notes valides`() {
        // Given
        val notes = arrayOf(12.0, 14.5, 16.0, 10.5)

        // When
        val resultat = calculerMoyenne(notes)

        // Then
        assertEquals(13.25, resultat, 0.01)
    }

    @Test
    fun `test moyenne avec une seule note`() {
        // Given
        val notes = arrayOf(15.0)

        // When
        val resultat = calculerMoyenne(notes)

        // Then
        assertEquals(15.0, resultat, 0.01)
    }

    @Test
    fun `test moyenne avec toutes les notes à 20`() {
        // Given
        val notes = arrayOf(20.0, 20.0, 20.0)

        // When
        val resultat = calculerMoyenne(notes)

        // Then
        assertEquals(20.0, resultat, 0.01)
    }

    @Test
    fun `test moyenne avec toutes les notes à 0`() {
        // Given
        val notes = arrayOf(0.0, 0.0, 0.0)

        // When
        val resultat = calculerMoyenne(notes)

        // Then
        assertEquals(0.0, resultat, 0.01)
    }

    @Test
    fun `test avec tableau vide`() {
        // Given
        val notes = arrayOf<Double>()

        // When & Then
        val exception = assertThrows<IllegalArgumentException> {
            calculerMoyenne(notes)
        }
        assertEquals("Impossible de calculer une moyenne sans notes !", exception.message)
    }

    @Test
    fun `test avec note negative`() {
        // Given
        val notes = arrayOf(12.0, -5.0, 16.0)

        // When & Then
        assertThrows<IllegalArgumentException> {
            calculerMoyenne(notes)
        }
    }

    @Test
    fun `test avec note superieure à 20`() {
        // Given
        val notes = arrayOf(12.0, 25.0, 16.0)

        // When & Then
        assertThrows<IllegalArgumentException> {
            calculerMoyenne(notes)
        }
    }

}