package mx.com.misterjob.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;

public class AuditoriaDto {
	private Long idAudit;
	private Integer idUser;
	private Byte idAction;
	private String actionDescription;
	private Byte idTable;
	private String tableName;
	private Integer recordId;
	private JsonNode oldData;
	private JsonNode newData;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime madeAt;
	
	public AuditoriaDto() {
		super();
	}

	public AuditoriaDto(Long idAudit, Integer idUser, Byte idAction, Byte idTable, Integer recordId, JsonNode oldData,
			JsonNode newData, LocalDateTime madeAt) {
		super();
		this.idAudit = idAudit;
		this.idUser = idUser;
		this.idAction = idAction;
		this.idTable = idTable;
		this.recordId = recordId;
		this.oldData = oldData;
		this.newData = newData;
		this.madeAt = madeAt;
	}

	public Long getIdAudit() {
		return idAudit;
	}

	public void setIdAudit(Long idAudit) {
		this.idAudit = idAudit;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Byte getIdAction() {
		return idAction;
	}

	public void setIdAction(Byte idAction) {
		this.idAction = idAction;
	}

	public Byte getIdTable() {
		return idTable;
	}

	public void setIdTable(Byte idTable) {
		this.idTable = idTable;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public JsonNode getOldData() {
		return oldData;
	}

	public void setOldData(JsonNode oldData) {
		this.oldData = oldData;
	}

	public JsonNode getNewData() {
		return newData;
	}

	public void setNewData(JsonNode newData) {
		this.newData = newData;
	}

	public LocalDateTime getMadeAt() {
		return madeAt;
	}

	public void setMadeAt(LocalDateTime madeAt) {
		this.madeAt = madeAt;
	}

	public String getActionDescription() {
		return actionDescription;
	}

	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String toString() {
		return "AuditoriaDto [idAudit=" + idAudit + ", idUser=" + idUser + ", idAction=" + idAction
				+ ", actionDescription=" + actionDescription + ", idTable=" + idTable + ", tableName=" + tableName
				+ ", recordId=" + recordId + ", oldData=" + oldData + ", newData=" + newData + ", madeAt=" + madeAt
				+ "]";
	}

}
