package no.nav.bidrag.behandling.felles.grunnlag

import java.time.LocalDate

class DeltBosted(override val soknadsbarnId: Int, val isDeltBosted: Boolean, datoFom: LocalDate, datoTil: LocalDate?) :
    Periode<DeltBosted>(datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

    override fun isEqualTo(other: DeltBosted): Boolean {
        return soknadsbarnId == other.soknadsbarnId && isDeltBosted == other.isDeltBosted
    }
}
