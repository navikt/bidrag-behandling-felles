package no.nav.bidrag.behandling.felles.grunnlag.delberegning

import no.nav.bidrag.behandling.felles.grunnlag.IGrunnlagInnhold
import no.nav.bidrag.behandling.felles.grunnlag.ISoknadsbarn
import java.math.BigDecimal
import java.time.LocalDate

class SluttberegningBBM(
    override val soknadsbarnId: Int,
    val beregnetBidragBelop: BigDecimal,
    val endeligBidragBelop: BigDecimal,
    val resultatKode: String,
    grunnlagReferanseListe: List<String>,
    datoFom: LocalDate,
    datoTil: LocalDate?
) :
    Delberegning<SluttberegningBBM>(grunnlagReferanseListe, datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

    override fun isEqualTo(other: SluttberegningBBM): Boolean {
        return soknadsbarnId == other.soknadsbarnId && beregnetBidragBelop == other.beregnetBidragBelop && endeligBidragBelop == other.endeligBidragBelop && resultatKode == other.resultatKode
    }
}
