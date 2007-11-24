/*
 * Sequence.java
 * 
 * Created on 27-oct-2007, 18:02:18
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.st;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author demian
 */
@Entity
@Table(name = "sequence")
@NamedQueries({@NamedQuery(name = "Sequence.findBySeqType", query = "SELECT s FROM Sequence s WHERE s.seqType = :seqType"), @NamedQuery(name = "Sequence.findBySeqId", query = "SELECT s FROM Sequence s WHERE s.seqId = :seqId")})
public class Sequence implements Serializable {
    @Id
    @Column(name = "seq_type", nullable = false)
    private String seqType;
    @Column(name = "seq_id", nullable = false)
    private int seqId;

    public Sequence() {
    }

    public Sequence(String seqType) {
        this.seqType = seqType;
    }

    public Sequence(String seqType, int seqId) {
        this.seqType = seqType;
        this.seqId = seqId;
    }

    public String getSeqType() {
        return seqType;
    }

    public void setSeqType(String seqType) {
        this.seqType = seqType;
    }

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqType != null ? seqType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sequence)) {
            return false;
        }
        Sequence other = (Sequence) object;
        if ((this.seqType == null && other.seqType != null) || (this.seqType != null && !this.seqType.equals(other.seqType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.st.Sequence[seqType=" + seqType + "]";
    }


}
