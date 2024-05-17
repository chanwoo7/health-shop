package com.healthshop.healthshop.domain.member;

import com.healthshop.healthshop.domain.Address;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberAddress extends Address {

    @Id @GeneratedValue
    @Column(name = "member_address_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private Boolean isDefault = false;

    //==연관관계 편의 메서드==//
    public void setMember(Member member){
        this.member = member;
        member.getMemberAddresses().add(this);
    }

    //==생성 메서드==//
    // TODO: 메서드 파라미터가 많으므로, 추후 빌더 패턴 고려할 것
    public static MemberAddress createAddress(Member member,
                                              String addressMain,
                                              String addressDetail,
                                              String zipcode,
                                              String name,
                                              String phone,
                                              String request) {
        MemberAddress memberAddress = new MemberAddress();
        memberAddress.setMember(member);
        memberAddress.setAddressMain(addressMain);
        memberAddress.setAddressDetail(addressDetail);
        memberAddress.setZipcode(zipcode);
        memberAddress.setName(name);
        memberAddress.setPhone(phone);
        memberAddress.setRequest(request);
        memberAddress.setIsDefault(member.getDefaultAddress().isEmpty());
        return memberAddress;
    }

}
