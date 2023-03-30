package no.nav.bidrag.behandling.felles.grunnlag

import java.time.LocalDate

class BarnIHusstand(val antall: Double, datoFom: LocalDate, datoTil: LocalDate?) :
    Periode<BarnIHusstand>(datoFom, datoTil),
    IGrunnlagInnhold {

    override fun isEqualTo(other: BarnIHusstand): Boolean {
        return antall == other.antall
    }
}
