import Highcharts from 'highcharts'
import HighchartsReact from 'highcharts-react-official'
import secimSonuc2014DataTurkiyeGenel from "../data/secimSonuc2014DataTurkiyeGenel";
const options = {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: '2014 Cumhurbaşkanlığı Seçim Sonuçları '
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    accessibility: {
        point: {
            valueSuffix: '%'
        }
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: false
            },
            showInLegend: true
        }
    },
    series: [{
        name: 'Türkiye Geneli',
        colorByPoint: true,
        data: secimSonuc2014DataTurkiyeGenel
    }]
};

const PieExample = () => <div>
    <HighchartsReact
        highcharts={Highcharts}
        options={options}
    />
</div>

export default PieExample;