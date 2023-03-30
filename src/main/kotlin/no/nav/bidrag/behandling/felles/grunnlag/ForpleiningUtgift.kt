package no.nav.bidrag.behandling.felles.grunnlag

import java.math.BigDecimal
import java.time.LocalDate

class ForpleiningUtgift(datoFom: LocalDate, datoTil: LocalDate?, override val soknadsbarnId: Int, val belop: BigDecimal) :
    Periode<ForpleiningUtgift>(datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

    override fun isEqualTo(other: ForpleiningUtgift): Boolean {
        return soknadsbarnId == other.soknadsbarnId && belop == other.belop
    }
}
