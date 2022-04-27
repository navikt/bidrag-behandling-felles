package no.nav.bidrag.behandling.felles.grunnlag.inntekt

import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.LocalDate

class InntektgrunnlagPost(
  val utbetalingsperiode: String,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  val opptjeningsperiodeFra: LocalDate,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  val opptjeningsperiodeTil: LocalDate,
  val opplysningspliktigId: String,
  val virksomhetId: String,
  val inntektType: String,
  val fordelType: String,
  val beskrivelse: String,
  val belop: BigDecimal,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  val etterbetalingsperiodeFra: LocalDate,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  val etterbetalingsperiodeTil: LocalDate
) {

}