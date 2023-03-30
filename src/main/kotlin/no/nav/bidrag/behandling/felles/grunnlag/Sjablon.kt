package no.nav.bidrag.behandling.felles.grunnlag

import java.time.LocalDate

class Sjablon(val sjablonNavn: String, val sjablonVerdi: String, datoFom: LocalDate, datoTil: LocalDate?) :
    Periode<Sjablon>(datoFom, datoTil), IGrunnlagInnhold {

    override fun isEqualTo(other: Sjablon): Boolean {
        val nameEquals = sjablonNavn == other.sjablonNavn
        val verdiEquals = sjablonVerdi == other.sjablonVerdi
        return nameEquals && verdiEquals
    }
}
