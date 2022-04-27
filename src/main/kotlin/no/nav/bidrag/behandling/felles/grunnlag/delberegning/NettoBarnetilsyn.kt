package no.nav.bidrag.behandling.felles.grunnlag.delberegning

import no.nav.bidrag.behandling.felles.grunnlag.IGrunnlagInnhold
import no.nav.bidrag.behandling.felles.grunnlag.ISoknadsbarn
import java.math.BigDecimal
import java.time.LocalDate

class NettoBarnetilsyn(
  override val soknadsbarnId: Int,
  val belop: BigDecimal,
  grunnlagReferanseListe: List<String>,
  datoFom: LocalDate,
  datoTil: LocalDate
) :
  Delberegning<NettoBarnetilsyn>(grunnlagReferanseListe, datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

  override fun isEqualTo(other: NettoBarnetilsyn): Boolean {
    return soknadsbarnId == other.soknadsbarnId && belop == other.belop
  }

}