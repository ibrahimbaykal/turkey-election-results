import React, {useState,useEffect} from 'react';
import axios from "axios";

const DataGetir = () => {
    const url = "https://sonuc.ysk.gov.tr/api/getSecimSandikSonucList?\n" +
        "secimId=40122&\n" +
        "secimTuru=9&\n" +
        "ilId=21&\n" +
        "ilceId=&\n" +
        "beldeId=&\n" +
        "birimId=&\n" +
        "muhtarlikId=&\n" +
        "cezaeviId=&\n" +
        "sandikTuru=&\n" +
        "sandikNoIlk=&\n" +
        "sandikNoSon=&\n" +
        "ulkeId=&\n" +
        "disTemsilcilikId=&\n" +
        "gumrukId=&\n" +
        "yurtIciDisi=1&\n" +
        "sandikRumuzIlk=&\n" +
        "sandikRumuzSon=&\n" +
        "secimCevresiId=258209&\n" +
        "sandikId=&\n" +
        "sorguTuru=2";

    const getSecimSonuc = () =>{
        // var i = 0;
        // while (i < 82) {
        //     const thisIterationI = i;
        //     setTimeout(function() {
        //         console.log(thisIterationI);
        //         axios.get(url)
        //             .then(function (response) {
        //                 console.log(response);
        //             })
        //             .catch(function (error) {
        //                 console.log(error);
        //             });
        //     }, i * 20000);
        //     i++;

        let plaka = 21;
        axios.get('https://sonuc.ysk.gov.tr/api/getSecimSandikSonucList', {
            params: {
                secimId: 40122,
                secimTuru:9,
                ilId:plaka,
                ilceId:"",
                beldeId:"",
                birimId:"",
                muhtarlikId:"",
                cezaeviId:"",
                sandikTuru:"",
                sandikNoIlk:"",
                sandikNoSon:"",
                ulkeId:"",
                disTemsilcilikId:"",
                gumrukId:"",
                yurtIciDisi:1,
                sandikRumuzIlk:"",
                sandikRumuzSon:"",
                secimCevresiId:258209,
                sandikId:"",
                sorguTuru:2,
            }
        })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
        }

    return (
        <div className="ui center aligned basic segment">
            <button className="ui primary button" onClick={getSecimSonuc}>
                Verileri Getir
            </button>
        </div>
    );
};

export default DataGetir;