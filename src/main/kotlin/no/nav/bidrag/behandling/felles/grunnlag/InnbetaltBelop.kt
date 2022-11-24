package no.nav.bidrag.behandling.felles.grunnlag

import java.math.BigDecimal

class InnbetaltBelop(
  override val soknadsbarnId: Int,
  val belop: BigDecimal
) : IGrunnlagInnhold, ISoknadsbarn