<template>
    <div class="page-user">
        <div class="avatar-wrapper">
            <div class="bg"></div>
            <div class="avatar">
                <div class="img"><open-data type="userAvatarUrl"></open-data></div>
                <div class="name">{{name}}</div>
            </div>
        </div>
        <div class="user-list">
            <i-cell-group>
                <i-cell @click="showEditName" title="用户昵称" :value="name" is-link></i-cell>
                <i-cell title="登录手机号" :value="mobile"></i-cell>
                <i-cell title="关于我们" is-link url="/pages/aboutUs/main"></i-cell>
                <i-cell title="设置" is-link url="/pages/setting/main"></i-cell>
            </i-cell-group>
        </div>
        <i-modal title="修改昵称" :visible="isShowEditName" @ok="confirmEdit" @cancel="cancelEdit">
            <i-input
                :i-class="isShowEditName ? 'name-line show' : 'name-line'"
                placeholder="请输入昵称"
                :autofocus="isShowEditName"
                type="text"
                @change="change"
                :value="editName"></i-input>
        </i-modal>

    </div>
</template>

<script>
    import { isForbidden } from "utils/stopRequest";
    import API from "api/apiList";

    export default {
        data() {
            return {
                name: '',
                isShowEditName: false,
                editName: ''
            }
        },
        onLoad() {
            wx.setNavigationBarColor({
                frontColor: "#000000",
                backgroundColor: "#f5d739"
            });
            const userInfo = wx.getStorageSync('userInfo');
            this.name = userInfo.nickname;
            console.log(`this.isShowEditName:${this.isShowEditName}`);
        },
        methods: {
            showEditName() {
                this.editName = this.name;
                this.isShowEditName = true;
            },
            async confirmEdit() {
                const userId = wx.getStorageSync('userId');
                const res = await this.$post(API.editUserInfo, {
                    userId,
                    nickName: this.editName
                })
                this.cancelEdit()
                if (res.status !== 200) return;
                this.name = this.editName
            },
            cancelEdit() {
                this.isShowEditName = false;
            },
            change(e) {
                console.log(e);
                this.editName = e.target.detail.value;
            }
        },
        computed: {
            mobile() {
                const userInfo = wx.getStorageSync('userInfo');
                return `${userInfo.phonenumber.slice(0,3)}****${userInfo.phonenumber.slice(7)}`
            }
        }
    };
</script>

<style scoped lang="less">
    @import "../../styles/mixin";

    .page-user {
        .avatar-wrapper {
            position: relative;
            height: 200px;
            background: #fff;
            width: 100vw;
            overflow: hidden;
            .bg {
                width: 120vw;
                height: 300px;
                border-radius: 50%;
                background: @mainColor;
                position: absolute;
                top: -220px;
                left: -10vw;
            }
            .avatar {
                position: absolute;
                z-index: 10;
                top: 40px;
                left: 50%;
                transform: translate(-50%, 0);
                .img {
                    width: 90px;
                    height: 90px;
                    border-radius: 50%;
                    overflow: hidden;
                }
                .name {
                    margin-top: 10px;
                    color: @fontColor3;
                    text-align: center;
                }
            }
        }
        .name-line {
            border-bottom: 1rpx solid @mainColor;
            display: none;
            &.show {
                display: inherit;
            }
        }
        .modal {
            position: fixed;
            width: 100vw;
            top: 0;
            bottom: 0;
            right: 0;
            left: 0;
        }
    }
</style>
