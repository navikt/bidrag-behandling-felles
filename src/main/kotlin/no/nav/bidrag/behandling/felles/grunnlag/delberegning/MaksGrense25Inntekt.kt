package no.nav.bidrag.behandling.felles.grunnlag.delberegning

import no.nav.bidrag.behandling.felles.grunnlag.IGrunnlagInnhold
import no.nav.bidrag.behandling.felles.grunnlag.ISoknadsbarn
import java.math.BigDecimal
import java.time.LocalDate

class MaksGrense25Inntekt(
    val inntektsgrunnlag: BigDecimal,
    val sumBidragAar: BigDecimal,
    val beregnetBelop: BigDecimal,
    val justertBelop: BigDecimal,
    override val soknadsbarnId: Int,
    grunnlagReferanseListe: List<String>,
    datoFom: LocalDate,
    datoTil: LocalDate?
) :
    Delberegning<MaksGrense25Inntekt>(grunnlagReferanseListe, datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

    override fun isEqualTo(other: MaksGrense25Inntekt): Boolean {
        return inntektsgrunnlag == other.inntektsgrunnlag && sumBidragAar == other.sumBidragAar && beregnetBelop == other.beregnetBelop && justertBelop == other.justertBelop && soknadsbarnId == other.soknadsbarnId
    }
}
