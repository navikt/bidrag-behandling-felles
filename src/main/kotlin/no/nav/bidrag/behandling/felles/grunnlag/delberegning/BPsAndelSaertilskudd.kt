package no.nav.bidrag.behandling.felles.grunnlag.delberegning

import no.nav.bidrag.behandling.felles.grunnlag.IGrunnlagInnhold
import no.nav.bidrag.behandling.felles.grunnlag.ISoknadsbarn
import java.math.BigDecimal
import java.time.LocalDate

class BPsAndelSaertilskudd(
  val soktBelop: BigDecimal,
  val beregnetBelop: BigDecimal,
  val fulltForskuddsBelop: BigDecimal,
  val barnMaksInntektBelop: BigDecimal,
  val fordelKlasseIIbelop: BigDecimal,
  val prosent: Double,
  override val soknadsbarnId: Int,
  grunnlagReferanseListe: List<String>,
  datoFom: LocalDate,
  datoTil: LocalDate?
) :
  Delberegning<BPsAndelSaertilskudd>(grunnlagReferanseListe, datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

  override fun isEqualTo(other: BPsAndelSaertilskudd): Boolean {
    return soktBelop == other.soktBelop && beregnetBelop == other.beregnetBelop && fulltForskuddsBelop == other.fulltForskuddsBelop && barnMaksInntektBelop == other.barnMaksInntektBelop && fordelKlasseIIbelop == other.fordelKlasseIIbelop && prosent == other.prosent && soknadsbarnId == other.soknadsbarnId
  }
}