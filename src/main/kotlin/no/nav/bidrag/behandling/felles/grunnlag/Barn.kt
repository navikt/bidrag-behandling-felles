package no.nav.bidrag.behandling.felles.grunnlag

import no.nav.bidrag.behandling.felles.enums.Rolle
import java.time.LocalDate

class Barn(val rolle: Rolle, datoFom: LocalDate, datoTil: LocalDate?, override val soknadsbarnId: Int) :
    Periode<Barn>(datoFom, datoTil),
    IGrunnlagInnhold,
    ISoknadsbarn {

    override fun isEqualTo(other: Barn): Boolean {
        return rolle == other.rolle && soknadsbarnId == other.soknadsbarnId
    }
}
