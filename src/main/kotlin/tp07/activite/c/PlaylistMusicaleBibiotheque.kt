package tp07.activite.c

fun calculerDureeTotale(durees: Array<Int>): Int {
    var dureeTotale = 0
    for (duree in durees) {
        dureeTotale += duree
    }
    return dureeTotale
}