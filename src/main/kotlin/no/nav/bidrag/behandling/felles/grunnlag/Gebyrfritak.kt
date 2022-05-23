package no.nav.bidrag.behandling.felles.grunnlag

import com.fasterxml.jackson.annotation.JsonFormat
import no.nav.bidrag.behandling.felles.enums.Rolle
import java.math.BigDecimal
import java.time.LocalDate

class Gebyrfritak(
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  val soktDato: LocalDate,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  val vedtakDato: LocalDate?,
  val innvilget: Boolean,
  val kode: String?,
  val grenseBelop: BigDecimal,
  val rolle: Rolle
) :
  IGrunnlagInnhold {

}