package com.healthshop.healthshop.domain.member;

import com.healthshop.healthshop.domain.AbstractAddress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Address extends AbstractAddress {

    @Id @GeneratedValue
    @Column(name = "address_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private Boolean isDefault = false;

    //==연관관계 편의 메서드==//
    public void setMember(Member member){
        this.member = member;
        member.getAddresses().add(this);
    }

    //==생성 메서드==//
    // TODO: 메서드 파라미터가 많으므로, 추후 빌더 패턴 고려할 것
    public static Address createAddress(Member member,
                                        String addressMain,
                                        String addressDetail,
                                        String zipcode,
                                        String name,
                                        String phone,
                                        String request) {
        Address address = new Address();
        address.setMember(member);
        address.setAddressMain(addressMain);
        address.setAddressDetail(addressDetail);
        address.setZipcode(zipcode);
        address.setName(name);
        address.setPhone(phone);
        address.setRequest(request);
        address.setIsDefault(member.getDefaultAddress().isEmpty());
        return address;
    }

}
