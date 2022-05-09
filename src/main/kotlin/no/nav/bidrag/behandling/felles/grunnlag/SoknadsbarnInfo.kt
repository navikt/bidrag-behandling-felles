package no.nav.bidrag.behandling.felles.grunnlag

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import java.time.LocalDate

class SoknadsbarnInfo(
  override val soknadsbarnId: Int,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @JsonSerialize(using = LocalDateSerializer::class)
  @JsonDeserialize(using = LocalDateDeserializer::class)
  val fodselsdato: LocalDate,
  val fnr: String) : IGrunnlagInnhold, ISoknadsbarn {}