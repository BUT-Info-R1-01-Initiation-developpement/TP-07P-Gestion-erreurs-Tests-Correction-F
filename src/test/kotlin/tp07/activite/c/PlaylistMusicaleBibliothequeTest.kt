package tp07.activite.c

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class PlaylistMusicaleTest {

    // ========== Tests pour calculerDureeTotale ==========
/*
    @Test
    fun `calculerDureeTotale avec plusieurs chansons`() {
        // Given
        val durees = arrayOf(120, 180, 150, 200)

        // When
        val resultat = calculerDureeTotale(durees)

        // Then
        assertEquals(650, resultat)
    }

    @Test
    fun `calculerDureeTotale avec une seule chanson`() {
        // Given
        val durees = arrayOf(300)

        // When
        val resultat = calculerDureeTotale(durees)

        // Then
        assertEquals(300, resultat)
    }

    @Test
    fun `calculerDureeTotale avec toutes les durées à zéro`() {
        // Given
        val durees = arrayOf(0, 0, 0)

        // When
        val resultat = calculerDureeTotale(durees)

        // Then
        assertEquals(0, resultat)
    }

    @Test
    fun `calculerDureeTotale avec tableau vide`() {
        // Given
        val durees = arrayOf<Int>()

        // When
        val resultat = calculerDureeTotale(durees)

        // Then
        assertEquals(0, resultat)
    }

    // ========== Tests pour trouverIndexChansonPlusLongue ==========

    @Test
    fun `trouverIndexChansonPlusLongue avec chanson longue au milieu`() {
        // Given
        val durees = arrayOf(120, 300, 150, 200)

        // When
        val resultat = trouverIndexChansonPlusLongue(durees)

        // Then
        assertEquals(1, resultat)
    }

    @Test
    fun `trouverIndexChansonPlusLongue avec chanson longue au début`() {
        // Given
        val durees = arrayOf(500, 120, 150, 200)

        // When
        val resultat = trouverIndexChansonPlusLongue(durees)

        // Then
        assertEquals(0, resultat)
    }

    @Test
    fun `trouverIndexChansonPlusLongue avec chanson longue à la fin`() {
        // Given
        val durees = arrayOf(120, 150, 200, 600)

        // When
        val resultat = trouverIndexChansonPlusLongue(durees)

        // Then
        assertEquals(3, resultat)
    }

    @Test
    fun `trouverIndexChansonPlusLongue avec toutes les durées identiques`() {
        // Given
        val durees = arrayOf(180, 180, 180)

        // When
        val resultat = trouverIndexChansonPlusLongue(durees)

        // Then
        assertEquals(0, resultat) // Devrait retourner le premier index
    }

    @Test
    fun `trouverIndexChansonPlusLongue avec une seule chanson`() {
        // Given
        val durees = arrayOf(250)

        // When
        val resultat = trouverIndexChansonPlusLongue(durees)

        // Then
        assertEquals(0, resultat)
    }

    @Test
    fun `trouverIndexChansonPlusLongue avec tableau vide lance exception`() {
        // Given
        val durees = arrayOf<Int>()

        // When & Then
        assertThrows<IllegalArgumentException> {
            trouverIndexChansonPlusLongue(durees)
        }
    }

    // ========== Tests pour ajouterChanson ==========

    @Test
    fun `ajouterChanson avec titre et durée valides`() {
        // Given
        val titres = Array(3) { "" }
        val durees = Array(3) { 0 }
        val titre = "Bohemian Rhapsody"
        val duree = 354

        // When
        ajouterChanson(titres, durees, 0, titre, duree)

        // Then
        assertEquals("Bohemian Rhapsody", titres[0])
        assertEquals(354, durees[0])
    }

    @Test
    fun `ajouterChanson ajoute plusieurs chansons`() {
        // Given
        val titres = Array(3) { "" }
        val durees = Array(3) { 0 }

        // When
        ajouterChanson(titres, durees, 0, "Song 1", 120)
        ajouterChanson(titres, durees, 1, "Song 2", 180)
        ajouterChanson(titres, durees, 2, "Song 3", 240)

        // Then
        assertEquals("Song 1", titres[0])
        assertEquals(120, durees[0])
        assertEquals("Song 2", titres[1])
        assertEquals(180, durees[1])
        assertEquals("Song 3", titres[2])
        assertEquals(240, durees[2])
    }

    @Test
    fun `ajouterChanson avec durée minimale valide`() {
        // Given
        val titres = Array(1) { "" }
        val durees = Array(1) { 0 }

        // When
        ajouterChanson(titres, durees, 0, "Intro", 1)

        // Then
        assertEquals("Intro", titres[0])
        assertEquals(1, durees[0])
    }

    @Test
    fun `ajouterChanson avec durée maximale valide`() {
        // Given
        val titres = Array(1) { "" }
        val durees = Array(1) { 0 }

        // When
        ajouterChanson(titres, durees, 0, "Epic Song", 600)

        // Then
        assertEquals("Epic Song", titres[0])
        assertEquals(600, durees[0])
    }

    @Test
    fun `ajouterChanson avec titre vide lance exception`() {
        // Given
        val titres = Array(1) { "" }
        val durees = Array(1) { 0 }

        // When & Then
        assertThrows<IllegalArgumentException> {
            ajouterChanson(titres, durees, 0, "", 300)
        }
    }

    @Test
    fun `ajouterChanson avec titre composé uniquement d'espaces lance exception`() {
        // Given
        val titres = Array(1) { "" }
        val durees = Array(1) { 0 }

        // When & Then
        assertThrows<IllegalArgumentException> {
            ajouterChanson(titres, durees, 0, "   ", 300)
        }
    }

    @Test
    fun `ajouterChanson avec durée zéro lance exception`() {
        // Given
        val titres = Array(1) { "" }
        val durees = Array(1) { 0 }

        // When & Then
        assertThrows<IllegalArgumentException> {
            ajouterChanson(titres, durees, 0, "Invalid Song", 0)
        }
    }

    @Test
    fun `ajouterChanson avec durée négative lance exception`() {
        // Given
        val titres = Array(1) { "" }
        val durees = Array(1) { 0 }

        // When & Then
        assertThrows<IllegalArgumentException> {
            ajouterChanson(titres, durees, 0, "Bad Duration", -50)
        }
    }

    @Test
    fun `ajouterChanson avec durée supérieure à 600 lance exception`() {
        // Given
        val titres = Array(1) { "" }
        val durees = Array(1) { 0 }

        // When & Then
        assertThrows<IllegalArgumentException> {
            ajouterChanson(titres, durees, 0, "Too Long Song", 650)
        }
    }

    @Test
    fun `ajouterChanson avec index invalide lance exception`() {
        // Given
        val titres = Array(3) { "" }
        val durees = Array(3) { 0 }

        // When & Then
        assertThrows<IllegalArgumentException> {
            ajouterChanson(titres, durees, -1, "Song", 120)
        }
    }

    @Test
    fun `ajouterChanson avec index hors limites lance exception`() {
        // Given
        val titres = Array(3) { "" }
        val durees = Array(3) { 0 }

        // When & Then
        assertThrows<IllegalArgumentException> {
            ajouterChanson(titres, durees, 5, "Song", 120)
        }
    }
 */
}