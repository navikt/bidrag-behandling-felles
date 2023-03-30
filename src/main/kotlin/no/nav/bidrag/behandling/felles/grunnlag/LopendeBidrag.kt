package no.nav.bidrag.behandling.felles.grunnlag

import java.math.BigDecimal
import java.time.LocalDate

class LopendeBidrag(
    override val soknadsbarnId: Int,
    val bpAndelUnderholdskostnadBelop: BigDecimal,
    val bidragBelop: BigDecimal,
    val samvaersfradragBelop: BigDecimal,
    datoFom: LocalDate,
    datoTil: LocalDate?
) :
    Periode<LopendeBidrag>(datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

    override fun isEqualTo(other: LopendeBidrag): Boolean {
        return soknadsbarnId == other.soknadsbarnId && bpAndelUnderholdskostnadBelop == other.bpAndelUnderholdskostnadBelop && bidragBelop == other.bidragBelop && samvaersfradragBelop == other.samvaersfradragBelop
    }
}
