package no.nav.bidrag.behandling.felles.grunnlag.delberegning

import no.nav.bidrag.behandling.felles.grunnlag.IGrunnlagInnhold
import no.nav.bidrag.behandling.felles.grunnlag.ISoknadsbarn
import java.math.BigDecimal
import java.time.LocalDate

class MaksBidragPerBarn(
  val maksBelop: BigDecimal,
  val beregnetBelop: BigDecimal,
  val justertBelop: BigDecimal,
  override val soknadsbarnId: Int,
  grunnlagReferanseListe: List<String>,
  datoFom: LocalDate,
  datoTil: LocalDate?
) :
  Delberegning<MaksBidragPerBarn>(grunnlagReferanseListe, datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

  override fun isEqualTo(other: MaksBidragPerBarn): Boolean {
    return maksBelop == other.maksBelop && beregnetBelop == other.beregnetBelop && justertBelop == other.justertBelop
  }
}