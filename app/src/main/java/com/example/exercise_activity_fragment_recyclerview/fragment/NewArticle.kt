package com.example.exercise_activity_fragment_recyclerview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_activity_fragment_recyclerview.R
import com.example.exercise_activity_fragment_recyclerview.adapter.AdapterListNewsArticle
import com.example.exercise_activity_fragment_recyclerview.databinding.FragmentNewArticleBinding
import com.example.exercise_activity_fragment_recyclerview.model.NewsArticle
import com.example.exercise_activity_fragment_recyclerview.model.NewsArticle.Companion.ITEM_NEW_ARTICLE_HEADER
import com.example.exercise_activity_fragment_recyclerview.model.NewsArticle.Companion.ITEM_NEW_ARTICLE_HOT
import com.example.exercise_activity_fragment_recyclerview.model.NewsArticle.Companion.ITEM_NEW_ARTICLE_NORMAL
import com.example.exercise_activity_fragment_recyclerview.untils.CommunicationFragmentNews

class NewArticle(var listener: CommunicationFragmentNews) : Fragment() {

    private val binding: FragmentNewArticleBinding by lazy {
        FragmentNewArticleBinding.inflate(
            layoutInflater
        )
    }
    private lateinit var newArticles: MutableList<NewsArticle>
    private lateinit var adapterNewArticle: AdapterListNewsArticle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        handingRecycler()
    }

    private fun handingRecycler() {
        newArticles = mutableListOf()
        newArticles.add(
            NewsArticle(
                R.mipmap.main,
                "3 Sept 2020",
                "ALT -3,87%",
                "ATLANTIA",
                "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus",
                "THÔNG BÁO VỀ 18 CA MẮC MỚI (BN3490 - BN3507)\n" +
                        "\n" +
                        "Trong đó: 02 ca được cách ly ngay sau khi nhập cảnh tại Đồng Nai ; 16 ca mắc ghi nhận trong nước tại Bắc Giang (10), Hà Nội (2), Quảng Trị (2), Bắc Ninh (1), Hải Dương (1) đều là các ca trong khu cách ly, khu vực được phong tỏa.\n" +
                        "\n" +
                        "a. 02 ca được cách ly ngay sau khi nhập cảnh:\n" +
                        "\n" +
                        "- CA BỆNH BN3498 cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai: Bệnh nhân nữ, 38 tuổi, là công dân Việt Nam, địa chỉ tại huyện Lương Tài, tỉnh Bắc Ninh. Ngày 07/5/2021, bệnh nhân từ Thụy Điển quá cảnh Pháp nhập cảnh Sân bay Tân Sơn Nhất trên chuyến bay VN10 và được cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai. Kết quả xét nghiệm ngày 09/5/2021 dương tính với SAR-CoV-2. Hiện bệnh nhân đang được cách ly, điều trị tại Bệnh viện Phổi Đồng Nai.\n" +
                        "- CA BỆNH BN3499 cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai: Bệnh nhân nam, 27 tuổi, là chuyên gia, quốc tịch Ấn Độ. Ngày 07/5/2021, bệnh nhân từ Ấn Độ nhập cảnh Sân bay Tân Sơn Nhất trên chuyến bay QR970 và được cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai. Kết quả xét nghiệm ngày 09/5/2021 dương tính với SAR-CoV-2. Hiện bệnh nhân đang được cách ly, điều trị tại Bệnh viện Phổi Đồng Nai.\n" +
                        "\n" +
                        "b. 16 ca mắc ghi nhận trong nước\n" +
                        "\n" +
                        "- CA BỆNH BN3490 ghi nhận tại Thành phố Hà Nội: Bệnh nhân nam, 31 tuổi, địa chỉ tại huyện Lạng Giang, tỉnh Bắc Giang; có tiền sử chăm bệnh nhân điều trị tại Bệnh viện K cơ sở Tân Triều. Kết quả xét nghiệm ngày 10/5/2021 dương tính với SARS-CoV-2. Hiện bệnh nhân đang được cách ly, điều trị tại Bệnh viện Bệnh Nhiệt đới Trung ương cơ sở Đông Anh.",
                ITEM_NEW_ARTICLE_HEADER
            )
        )
        newArticles.add(
            NewsArticle(
                R.drawable.item_1,
                "3 Sept 2020",
                "ALT -3,87%",
                "ATLANTIA",
                "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus",
                "THÔNG BÁO VỀ 18 CA MẮC MỚI (BN3490 - BN3507)\n" +
                        "\n" +
                        "Trong đó: 02 ca được cách ly ngay sau khi nhập cảnh tại Đồng Nai ; 16 ca mắc ghi nhận trong nước tại Bắc Giang (10), Hà Nội (2), Quảng Trị (2), Bắc Ninh (1), Hải Dương (1) đều là các ca trong khu cách ly, khu vực được phong tỏa.\n" +
                        "\n" +
                        "a. 02 ca được cách ly ngay sau khi nhập cảnh:\n" +
                        "\n" +
                        "- CA BỆNH BN3498 cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai: Bệnh nhân nữ, 38 tuổi, là công dân Việt Nam, địa chỉ tại huyện Lương Tài, tỉnh Bắc Ninh. Ngày 07/5/2021, bệnh nhân từ Thụy Điển quá cảnh Pháp nhập cảnh Sân bay Tân Sơn Nhất trên chuyến bay VN10 và được cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai. Kết quả xét nghiệm ngày 09/5/2021 dương tính với SAR-CoV-2. Hiện bệnh nhân đang được cách ly, điều trị tại Bệnh viện Phổi Đồng Nai.\n" +
                        "- CA BỆNH BN3499 cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai: Bệnh nhân nam, 27 tuổi, là chuyên gia, quốc tịch Ấn Độ. Ngày 07/5/2021, bệnh nhân từ Ấn Độ nhập cảnh Sân bay Tân Sơn Nhất trên chuyến bay QR970 và được cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai. Kết quả xét nghiệm ngày 09/5/2021 dương tính với SAR-CoV-2. Hiện bệnh nhân đang được cách ly, điều trị tại Bệnh viện Phổi Đồng Nai.\n" +
                        "\n" +
                        "b. 16 ca mắc ghi nhận trong nước\n" +
                        "\n" +
                        "- CA BỆNH BN3490 ghi nhận tại Thành phố Hà Nội: Bệnh nhân nam, 31 tuổi, địa chỉ tại huyện Lạng Giang, tỉnh Bắc Giang; có tiền sử chăm bệnh nhân điều trị tại Bệnh viện K cơ sở Tân Triều. Kết quả xét nghiệm ngày 10/5/2021 dương tính với SARS-CoV-2. Hiện bệnh nhân đang được cách ly, điều trị tại Bệnh viện Bệnh Nhiệt đới Trung ương cơ sở Đông Anh. ",
                ITEM_NEW_ARTICLE_HOT
            )
        )
        newArticles.add(
            NewsArticle(
                R.drawable.item_2,
                "2 Sept 2020",
                "HKD -2,13%",
                "XIAOMI",
                "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus",
                "THÔNG BÁO VỀ 18 CA MẮC MỚI (BN3490 - BN3507)\n" +
                        "\n" +
                        "Trong đó: 02 ca được cách ly ngay sau khi nhập cảnh tại Đồng Nai ; 16 ca mắc ghi nhận trong nước tại Bắc Giang (10), Hà Nội (2), Quảng Trị (2), Bắc Ninh (1), Hải Dương (1) đều là các ca trong khu cách ly, khu vực được phong tỏa.\n" +
                        "\n" +
                        "a. 02 ca được cách ly ngay sau khi nhập cảnh:\n" +
                        "\n" +
                        "- CA BỆNH BN3498 cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai: Bệnh nhân nữ, 38 tuổi, là công dân Việt Nam, địa chỉ tại huyện Lương Tài, tỉnh Bắc Ninh. Ngày 07/5/2021, bệnh nhân từ Thụy Điển quá cảnh Pháp nhập cảnh Sân bay Tân Sơn Nhất trên chuyến bay VN10 và được cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai. Kết quả xét nghiệm ngày 09/5/2021 dương tính với SAR-CoV-2. Hiện bệnh nhân đang được cách ly, điều trị tại Bệnh viện Phổi Đồng Nai.\n" +
                        "- CA BỆNH BN3499 cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai: Bệnh nhân nam, 27 tuổi, là chuyên gia, quốc tịch Ấn Độ. Ngày 07/5/2021, bệnh nhân từ Ấn Độ nhập cảnh Sân bay Tân Sơn Nhất trên chuyến bay QR970 và được cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai. Kết quả xét nghiệm ngày 09/5/2021 dương tính với SAR-CoV-2. Hiện bệnh nhân đang được cách ly, điều trị tại Bệnh viện Phổi Đồng Nai.\n" +
                        "\n" +
                        "b. 16 ca mắc ghi nhận trong nước\n" +
                        "\n" +
                        "- CA BỆNH BN3490 ghi nhận tại Thành phố Hà Nội: Bệnh nhân nam, 31 tuổi, địa chỉ tại huyện Lạng Giang, tỉnh Bắc Giang; có tiền sử chăm bệnh nhân điều trị tại Bệnh viện K cơ sở Tân Triều. Kết quả xét nghiệm ngày 10/5/2021 dương tính với SARS-CoV-2. Hiện bệnh nhân đang được cách ly, điều trị tại Bệnh viện Bệnh Nhiệt đới Trung ương cơ sở Đông Anh. ",
                ITEM_NEW_ARTICLE_NORMAL
            )
        )
        newArticles.add(
            NewsArticle(
                R.drawable.item_3,
                "1 Sept 2020",
                "AAPL -0,91%",
                "APPLE",
                "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus",
                "THÔNG BÁO VỀ 18 CA MẮC MỚI (BN3490 - BN3507)\n" +
                        "\n" +
                        "Trong đó: 02 ca được cách ly ngay sau khi nhập cảnh tại Đồng Nai ; 16 ca mắc ghi nhận trong nước tại Bắc Giang (10), Hà Nội (2), Quảng Trị (2), Bắc Ninh (1), Hải Dương (1) đều là các ca trong khu cách ly, khu vực được phong tỏa.\n" +
                        "\n" +
                        "a. 02 ca được cách ly ngay sau khi nhập cảnh:\n" +
                        "\n" +
                        "- CA BỆNH BN3498 cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai: Bệnh nhân nữ, 38 tuổi, là công dân Việt Nam, địa chỉ tại huyện Lương Tài, tỉnh Bắc Ninh. Ngày 07/5/2021, bệnh nhân từ Thụy Điển quá cảnh Pháp nhập cảnh Sân bay Tân Sơn Nhất trên chuyến bay VN10 và được cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai. Kết quả xét nghiệm ngày 09/5/2021 dương tính với SAR-CoV-2. Hiện bệnh nhân đang được cách ly, điều trị tại Bệnh viện Phổi Đồng Nai.\n" +
                        "- CA BỆNH BN3499 cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai: Bệnh nhân nam, 27 tuổi, là chuyên gia, quốc tịch Ấn Độ. Ngày 07/5/2021, bệnh nhân từ Ấn Độ nhập cảnh Sân bay Tân Sơn Nhất trên chuyến bay QR970 và được cách ly ngay sau khi nhập cảnh tại tỉnh Đồng Nai. Kết quả xét nghiệm ngày 09/5/2021 dương tính với SAR-CoV-2. Hiện bệnh nhân đang được cách ly, điều trị tại Bệnh viện Phổi Đồng Nai.\n" +
                        "\n" +
                        "b. 16 ca mắc ghi nhận trong nước\n" +
                        "\n" +
                        "- CA BỆNH BN3490 ghi nhận tại Thành phố Hà Nội: Bệnh nhân nam, 31 tuổi, địa chỉ tại huyện Lạng Giang, tỉnh Bắc Giang; có tiền sử chăm bệnh nhân điều trị tại Bệnh viện K cơ sở Tân Triều. Kết quả xét nghiệm ngày 10/5/2021 dương tính với SARS-CoV-2. Hiện bệnh nhân đang được cách ly, điều trị tại Bệnh viện Bệnh Nhiệt đới Trung ương cơ sở Đông Anh. ",
                ITEM_NEW_ARTICLE_NORMAL
            )
        )
        adapterNewArticle =
            AdapterListNewsArticle(listener, newArticles)
        binding.lvNewArticle.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterNewArticle
        }
    }


}