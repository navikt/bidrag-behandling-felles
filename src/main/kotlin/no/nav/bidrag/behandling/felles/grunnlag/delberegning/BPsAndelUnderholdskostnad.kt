package no.nav.bidrag.behandling.felles.grunnlag.delberegning

import no.nav.bidrag.behandling.felles.grunnlag.IGrunnlagInnhold
import no.nav.bidrag.behandling.felles.grunnlag.ISoknadsbarn
import java.math.BigDecimal
import java.time.LocalDate

class BPsAndelUnderholdskostnad(
  override val soknadsbarnId: Int,
  val belop: BigDecimal,
  val prosent: Double,
  val isSelvforsorget: Boolean,
  grunnlagReferanseListe: List<String>,
  datoFom: LocalDate,
  datoTil: LocalDate
) :
  Delberegning<BPsAndelUnderholdskostnad>(grunnlagReferanseListe, datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

  override fun isEqualTo(other: BPsAndelUnderholdskostnad): Boolean {
    return soknadsbarnId == other.soknadsbarnId && belop == other.belop && prosent == other.prosent && isSelvforsorget == other.isSelvforsorget
  }

}