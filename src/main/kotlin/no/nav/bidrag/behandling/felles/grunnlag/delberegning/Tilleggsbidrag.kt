package no.nav.bidrag.behandling.felles.grunnlag.delberegning

import no.nav.bidrag.behandling.felles.grunnlag.IGrunnlagInnhold
import no.nav.bidrag.behandling.felles.grunnlag.ISoknadsbarn
import java.math.BigDecimal
import java.time.LocalDate

class Tilleggsbidrag(
  val grenseBidrag: BigDecimal,
  val prosentBidrag: BigDecimal,
  val inntektBPBelop: BigDecimal,
  val bidragBelop: BigDecimal,
  val isAvslag: Boolean,
  val antallTrinn: Int,
  override val soknadsbarnId: Int,
  grunnlagReferanseListe: List<String>,
  datoFom: LocalDate,
  datoTil: LocalDate?
) :
  Delberegning<Tilleggsbidrag>(grunnlagReferanseListe, datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

  override fun isEqualTo(other: Tilleggsbidrag): Boolean {
    return grenseBidrag == other.grenseBidrag && prosentBidrag == other.prosentBidrag && inntektBPBelop == other.inntektBPBelop &&
        bidragBelop == other.bidragBelop && isAvslag == other.isAvslag && antallTrinn == other.antallTrinn
  }
}