package cn.edu.usts.cs2018.entity;

public class Producer {
    public int id;
    public String workshopNo;
    public String producerNo;
    public String status;

    public Producer() {
    }

    public Producer(String workshopNo, String producerNo, String status) {
        this.workshopNo = workshopNo;
        this.producerNo = producerNo;
        this.status = status;
    }

    public Producer(int id, String workshopNo, String producerNo, String status) {
        this.id = id;
        this.workshopNo = workshopNo;
        this.producerNo = producerNo;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", workshopNo='" + workshopNo + '\'' +
                ", producerNo='" + producerNo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkshopNo() {
        return workshopNo;
    }

    public void setWorkshopNo(String workshopNo) {
        this.workshopNo = workshopNo;
    }

    public String getProducerNo() {
        return producerNo;
    }

    public void setProducerNo(String producerNo) {
        this.producerNo = producerNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
