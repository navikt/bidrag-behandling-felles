package no.nav.bidrag.behandling.felles.grunnlag

import java.time.LocalDate

class Skatteklasse(val skatteklasseId: Int, datoFom: LocalDate, datoTil: LocalDate?) :
    Periode<Skatteklasse>(datoFom, datoTil),
    IGrunnlagInnhold {

    override fun isEqualTo(other: Skatteklasse): Boolean {
        return skatteklasseId == other.skatteklasseId
    }
}
