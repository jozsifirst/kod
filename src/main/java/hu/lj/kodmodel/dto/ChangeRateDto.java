package hu.lj.kodmodel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ChangeRateDto {
	
	private Long id;
	private Long symbolFrom;
	private SymbolDto symbolFromEntity;
	private Long symbolTo;
	private SymbolDto symbolToEntity;
	private Long changeRate;

}
